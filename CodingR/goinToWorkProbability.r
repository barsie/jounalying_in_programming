# replicate

set.seed(110)
sims = 1000

# create vectors to track if it sunny and if person goes to work
sun = rep(0, sims)
work = rep(0, sims)

# run the loop
for(i in 1:sims){

    # generate a random weather instance
    weather = runif(1)

    # generate a random person going to work intance
    go = runif(1)

    if( weather <= .6){

        # say that it was sunny
        sun[i] = 1

        if(go <= .95){
            work[i] = 1
        }

    }

    if( weather <= .4){

        # say it was rainu

        if(go <= .3){
            work[i] = 1
        }
    }

}

print(mean(sun))
print(mean(work))