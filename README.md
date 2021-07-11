# Simulation-Memory-Consume
Basic simulator of how memory allocation works based on the memory to be allocated, a program developed in JAVA.

It works in the following way:

The idea is to simulate the way in which an OS allocates memory.

Then, the simulator will establish a series of days, and an amount of initial megabytes, every day those initial megabytes will be subtracted megabytes since they will be part of the consumption of a user.The average of these megabytes are 7000.

double memoryOrder = generateMemoryUse (5000, 8000); / * What this line does is generate a random use per day of memory on average that would be like 7000 or something like that * /
