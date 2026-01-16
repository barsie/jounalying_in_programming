# define the vector for size, topping and order\

size = c('S', 'M', 'L')
topping = c('pepperoni', 'sausage', 'meatbal', 'extra cheese')
order = c('deliver', 'pick up')

# keep track of the pizzas
pizzas = character(0)

# iterate over each value of the variable
for(i in 1:length(size)){
    for(j in 1:length(topping)){
        for(k in 1:length(order)){
            # create a pizza 

            pizzas = rbind(pizzas, c(size[i], topping[j], order[k]))
        }
    }
}

# print pizzas
print(pizzas) 

# count the total number of large sausages
print('------------------ Counting the total number of large sausages ----------------')
large_sausage = length(pizzas[pizzas[, 0] == "L" & pizzas[, 2] == 'sausage'])
print(large_sausage)

# count the total number of small pepperoni
print('------------------ Counting the total number of small peperoni -------------------')
count_small_pepperoni = length(pizzas[pizzas[, 1] == "S" & pizza[, 2] == 'pepperoni'])
print(count_samll_pepperoni)