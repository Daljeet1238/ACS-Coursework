//Initialize all the variables.
let num_items = 20;
let your_name = "Daljeet";
let original = [];
let upper = [];
let matches = {};
let starting_number = Number(prompt("Write a number"));

//Create an array of object.
for(let count = 1; count <= num_items; count++){
    let items = {
        name: your_name,
        sum: starting_number + count,
        product: starting_number * count
    };
    original.push(items);
}

//Function that creates a new array with name in uppercasae and multiply sum and product with 3
function toUpperTimesThree(input) {
    let result = [];
    for(let i = 0; i < input.length; i++){
        let values = input[i];
        let items = {
            name: values.name.toUpperCase(),
            sum: values.sum * 3,
            product: values.product * 3,
            div: values.product/ values.sum
        };
        result.push(items);
    }
    return result;
}

//calling toUpperTimesThree
upper = toUpperTimesThree(original);

//function that finds to matching items based on product and sum
function findMatchedItems(o, u){
    let sum_matches = [];
    let product_matches = [];
    for(i = 0; i < o.length; i++){
        for(j = 0; j < u.length; j++){
            //check if the sum is equal.
            if(o[i].sum === u[j].sum){
                let items = {
                    or: o[i],
                    up: u[j]
                }  
                sum_matches.push(items);
            }
            //check if the product is equal.
            if(o[i].product === u[j].product){
                let items = {
                    or: o[i],
                    up: u[j] 
                };
                product_matches.push(items);
            }
        }
    }
    return{
        sum_matches: sum_matches,
        product_matches: product_matches
    };
}
//find the matching items betweem the arrays and store them in the matches.
matches = findMatchedItems(original, upper);

//print the original, upper and matches array.
console.log('Original' , original);
console.log('Upper', upper);
console.log('Matches', matches);