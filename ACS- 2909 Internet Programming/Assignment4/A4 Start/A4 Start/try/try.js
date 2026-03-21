// Save the URL
let color_url = "https://acs2909.lusciousorange.com/colors.php?passcode=o402!Pke&username=singh-d87";

function init() {
    // Add submit event listener
    document.getElementById("color_form").addEventListener("submit", processFormSubmit);
}

function processFormSubmit(event) {
    event.preventDefault(); // Prevent form submission
    const selector = document.getElementById("color_selector");
    const value = selector.value;

    if (value === "random") {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', color_url, true); // Async request

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

        xhr.send();
    }
}

function processXHR(xhr) {
    const response = JSON.parse(xhr.responseText);
    const { name: color_name, code: color_code } = response;

    // Check if the color already exists in the <select>
    const selector = document.getElementById("color_selector");
    let exists = Array.from(selector.options).some(option => option.value === color_code);

    if (!exists) {
        addColorToSelect(color_code, color_name);
    }
    createNewSwatchBox(color_code, color_name);
}

function addColorToSelect(color_code, color_name) {
    const selector = document.getElementById("color_selector");
    const option = document.createElement("option");
    option.value = color_code;
    option.textContent = color_name;
    selector.appendChild(option);
}

function createNewSwatchBox(color_code, color_name) {
    const swatches = document.getElementById("swatches");
    const swatch = document.createElement("div");
    swatch.className = "swatch";
    swatch.style.backgroundColor = color_code;
    swatch.textContent = color_name;
    swatches.appendChild(swatch);
}

// Initialize the script after the page loads
document.addEventListener("DOMContentLoaded", init);
