// Creating class
class ParagraphChanger {

    constructor(paragraphElement){
        this.paragraph = paragraphElement;

        //Creating div
        this.buttonContainer = document.createElement('div');
        this.buttonContainer.id = "button_container";
        
        //Inserting buttonContainer before the paragraph
        document.body.insertBefore(this.buttonContainer, this.paragraph)

        //Declare the button titles
        const buttonTitles = ["Toggle Bold" , "Toggle Width", "Toggle Colour", "Toggle Font Size"];

        //loop through the button tiles
        for(let i = 0; i < buttonTitles.length; i++){
            const buttons = document.createElement("a");
            buttons.innerText = buttonTitles[i];
            buttons.href = "#";
            buttons.className = "buttons";

            //append to buttonContainer
            this.buttonContainer.appendChild(buttons);

            //provide the classes depend on the name
            buttons.addEventListener('click', () => {
                switch (buttonTitles[i]) {
                    case 'Toggle Bold':
                        this.paragraph.classList.toggle('bold');
                        break;
                    case 'Toggle Width':
                        this.paragraph.classList.toggle('width');
                        break;
                    case 'Toggle Colour':
                        this.paragraph.classList.toggle('ferrari-red');
                        break;
                    case 'Toggle Font Size':
                        this.paragraph.classList.toggle('double-font');
                        break;
                  }
            });
        }
    }

}

//Initilizing paragraphChanger 
document.addEventListener("DOMContentLoaded", () => {
    const paragraph = document.getElementById("target_p");
    new ParagraphChanger(paragraph);
});