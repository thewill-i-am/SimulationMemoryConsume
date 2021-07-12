# Simulation-Memory-Consume
Basic simulator of how memory allocation works based on the memory to be allocated, a program developed in JAVA.

It works in the following way:

The idea is to simulate the way in which an OS allocates memory.

Then, the simulator will establish a series of days, and an amount of initial megabytes, every day those initial megabytes will be subtracted megabytes since they will be part of the consumption of a user.The average of these megabytes are 7000.

<code>double memoryOrder = 7000 </code>

That's why I included that line above.

So that is going to be subtracted from the number of initial megabytes, logically the megabytes will be spent at some point when that happens there is a method <code>generateMemoryAlocation ()</code>, which basically what it does is allocate more memory if there is not enough , this has some interesting specs like:

<code>If the megabytes there are is greater than 28000 -> then only 31% more megabytes can be assigned to the current megabytes.</code>


<code>If the megabytes there are is less than 28000 -> then only 40% more megabytes can be assigned to the current megabytes.</code>

If neither allocating the necessary resources can allocate the amount of memory that is needed, then a message is written that the amount of memory cannot be allocated because there are not the physical resources to do that
