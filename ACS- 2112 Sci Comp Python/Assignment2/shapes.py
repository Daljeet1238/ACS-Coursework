from __future__ import print_function, division

import math
import turtle


def draw_pie(my_turtle, num_segments, radius):
    """Draws a pie, then moves into position to the right.

    my_turtle: Turtle
    num_segments: number of segments
    radius: length of the radial spokes
    """
    polypie(my_turtle, num_segments, radius)
    my_turtle.pu()
    my_turtle.fd(radius * 2 + 10)
    my_turtle.pd()


def polypie(my_turtle, num_segments, radius):
    """Draws a pie divided into radial segments.

    my_turtle: Turtle
    num_segments: number of segments
    radius: length of the radial spokes
    """
    angle = 360.0 / num_segments
    for i in range(num_segments):
        isosceles(my_turtle, radius, angle / 2)
        my_turtle.lt(angle)


def isosceles(my_turtle, equal_legs, peak_angle):
    """Draws an isosceles triangle.

    The turtle starts and ends at the peak, facing the middle of the base.

    my_turtle: Turtle
    equal_legs: length of the equal legs
    peak_angle: half peak angle in degrees
    """
    y = equal_legs * math.sin(peak_angle * math.pi / 180)

    my_turtle.rt(peak_angle)
    my_turtle.fd(equal_legs)
    my_turtle.lt(90 + peak_angle)
    my_turtle.fd(2 * y)
    my_turtle.lt(90 + peak_angle)
    my_turtle.fd(equal_legs)
    my_turtle.lt(180 - peak_angle)


my_custom_turtle = turtle.Turtle()

my_custom_turtle.pu()
my_custom_turtle.bk(130)
my_custom_turtle.pd()

# draw polypies with various numbers of sides
custom_size = 40
draw_pie(my_custom_turtle, 5, custom_size)
draw_pie(my_custom_turtle, 6, custom_size)
draw_pie(my_custom_turtle, 7, custom_size)
draw_pie(my_custom_turtle, 8, custom_size)

my_custom_turtle.hideturtle()
turtle.mainloop()