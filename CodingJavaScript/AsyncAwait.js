const fetchPromise = fetch("https://mdn.github.io/learning-area/javascript/apis/fetching-data/cans-store/products.json")

// console.log(fetchPromise)

// fetchPromise.then((response) => {
//     const jsonPromise = response.json();
//     jsonPromise.then((data) => {
//         console.log(data[8].name)
//     })
//     console.log(`Fetched Data received: ${response.status}`)
// })

// console.log("Request started...")

// the promise throws an error if we remove the url is malformed or corrupted from the server

fetchPromise
    .then((response) => {
        if(!response.ok){
            throw new Error(`HTTP error ${response.status}`);
        }
        return response.json()
    })
    .then((data) => {
        console.log(data[0].name)
    })
    .catch((error) => {
        console.log(`Could not load data from source. The output is ${error}`)
    })