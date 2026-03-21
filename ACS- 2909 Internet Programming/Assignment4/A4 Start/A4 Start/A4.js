// Save the URL
let color_url = "https://acs2909.lusciousorange.com/colors.php?passcode=o402!Pke&username=singh-d87";

//Set up the event listener for the form submission.
function init() {
    document.getElementById("color_form").addEventListener("submit", processFormSubmit);
}

//handle the submission of the form.
function processFormSubmit(event) {
    event.preventDefault(); //prevent to get the form to default.
    let selector = document.getElementById("color_selector");
    let value = selector.value;

    //cheecking the input value
    if (value === "random") {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", color_url, true);

        //handle the onload function or give error 
        xhr.onload = function () {
            if (xhr.status !== 200) {
                alert(`Error ${xhr.status}: ${xhr.statusText}`);
            } else {
                processXHR(xhr);
            }
        };

        xhr.onerror = function () {
            alert("Request failed");
        };

        //send the xhr. 
        xhr.send();
    }
}

function processXHR(xhr) {
    //converting response into JSON string.
    let response = JSON.parse(xhr.responseText);
    let color_code = response.code; // collects the color code.
    let color_name = response.name; // collects the color name.

    const selector = document.getElementById("color_selector");

    //check if the color already exists.
    for (let i = 0; i < selector.options.length; i++) {
        if (selector.options[i].value === color_code) {
            createNewSwatchBox(color_code, color_name);
            return;
        }
    }

    //adding the color to the dropdown list.
    addColorToSelect(color_code, color_name);
    createNewSwatchBox(color_code, color_name);
}

//add the new color option to the drop down list.
function addColorToSelect(color_code, color_name) {
    let selector = document.getElementById("color_selector");
    let option = document.createElement("option");
    option.value = color_code;
    option.textContent = color_name;
    selector.appendChild(option); //appending the new option to the select option.
}

//creating the new swatch box for the specific color.
function createNewSwatchBox(color_code, color_name) {
    let swatches = document.getElementById("swatches");
    let element = document.createElement("div");
    element.className = "swatch";
    element.style.backgroundColor = color_code;
    element.textContent = color_name;
    swatches.appendChild(element);
}

// Initialize the script after the DOM content has loaded
document.addEventListener("DOMContentLoaded", init);
