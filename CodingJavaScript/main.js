// Nested Functions
// let a = 10;
// function outer(){
//     let b = 20;
//     function inner(){
//         let c = 30;
//         console.log(a, b, c)
//     }
//     inner()
// }
// outer()

// CLOSURE

// function outer(){
//     let counter = 0;
//     function inner(){
//         counter ++;
//         console.log(counter)
//     }
//     return inner() // Returning a function
// }
// const fn = outer() // initializing a variable and passing it a function 
// console.log(fn)
// console.log(fn)

function Person(name, email){
    // This intanciate an empty object
    this.name = name;
    this.email = email;
}

const p1 = new Person("Piloto", "Nano@nano.com")
const p2 = new Person("Bonito", "PIco@pico.com")

Person.prototype.getDetails = function(){
    return this.name + " " + this.email
}

function IoTisPerson(type, model, name, email){
    this.type = type;
    this.model = model;

    // Call the person with the required attributes to inherit
    Person.call(this, name, email)
}

IoTisPerson.prototype.confimation = function(){
    console.log("Not Really")
}

IoTisPerson.prototype = Object.create(Person.prototype)

const IoT1 = new IoTisPerson("RasberriPi", "pi@pi.com", "CM32", "Micro")
IoTisPerson.prototype.constructor = Person();

console.log(IoT1.getDetails())
console.log(p2.getDetails())
console.log(p1.getDetails())
