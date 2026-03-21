import sys
import pygame
import random

# setting up some initial parameters
WIDTH, HEIGHT = 600, 600
BLOCK_SIZE = 20
pygame.font.init()
score_font = pygame.font.SysFont("consolas", 20)
# or any other font you'd like
score = 0

# color definition
WHITE = (255, 255, 255)
RED = (255, 0, 0)

# initialize pygame
pygame.init()

# setting up display
win = pygame.display.set_mode((WIDTH, HEIGHT))

# setting up clock
clock = pygame.time.Clock()

# snake and food initialization
snake_pos =  snake_speed = [0, BLOCK_SIZE]
teleport_walls = True # set this to True to enable wall teleporting

def generate_food():
    while True:
        x = random.randint(0, (WIDTH - BLOCK_SIZE) // BLOCK_SIZE) * BLOCK_SIZE
        y = random.randint(0, (HEIGHT - BLOCK_SIZE) // BLOCK_SIZE) * BLOCK_SIZE
        food_pos = [x, y]
        if food_pos not in snake_pos:
            return food_pos

food_pos = generate_food()

def draw_objects():
    win.fill((0, 0, 0))
    for pos in snake_pos:
        pygame.draw.rect(win, WHITE, pygame.Rect(pos, pos, BLOCK_SIZE, BLOCK_SIZE))
    pygame.draw.rect(win, RED, pygame.Rect(food_pos, food_pos, BLOCK_SIZE, BLOCK_SIZE))

    # Render the score
    score_text = score_font.render(f"Score: {score}", True, WHITE)
    win.blit(score_text, (10, 10)) # draws the score on the top-left corner

def update_snake():
    global food_pos, score
    new_head = [snake_pos + snake_speed, snake_pos + snake_speed]
    if teleport_walls:
        # if the new head position is outside of the screen, wrap it to the other side
        if new_head >= WIDTH:
            new_head = 0
        elif new_head < 0:
            new_head = WIDTH - BLOCK_SIZE
        if new_head >= HEIGHT:
            new_head = 0
        elif new_head < 0:
            new_head = HEIGHT - BLOCK_SIZE
    if new_head == food_pos:
        food_pos = generate_food() # generate new food
        score += 1 # increment score when food is eaten
    else:
        snake_pos.pop() # remove the last element from the snake
    snake_pos.insert(0, new_head) # add the new head to the snake

def game_over():
    # game over when snake hits the boundaries or runs into itself
    if teleport_walls:
        return snake_pos in snake_pos[1:]
    else:
        return snake_pos in snake_pos[1:] or \
            snake_pos > WIDTH - BLOCK_SIZE or \
            snake_pos < 0 or \
            snake_pos > HEIGHT - BLOCK_SIZE or \
            snake_pos < 0

def game_over_screen():
    global score
    win.fill((0, 0, 0))
    game_over_font = pygame.font.SysFont("consolas", 50)
    game_over_text = game_over_font.render(f"Game Over! Your score is {score}", True, WHITE)
    win.blit(game_over_text, (WIDTH // 2 - game_over_text.get_width() // 2, HEIGHT // 2 - game_over_text.get_height() // 2))
    pygame.display.flip()
    pygame.time.wait(3000)

# main game loop
while True:
    clock.tick(10) # set the game speed
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]:
        snake_speed = [-BLOCK_SIZE, 0]
    elif keys[pygame.K_RIGHT]:
        snake_speed = [BLOCK_SIZE, 0]
    elif keys[pygame.K_UP]:
        snake_speed = [0, -BLOCK_SIZE]
    elif keys[pygame.K_DOWN]:
        snake_speed = [0, BLOCK_SIZE]

    update_snake()
    if game_over():
        game_over_screen()
        score = 0
        snake_pos = snake_speed = [0, BLOCK_SIZE]
        food_pos = generate_food()

    draw_objects()
    pygame.display.flip()
