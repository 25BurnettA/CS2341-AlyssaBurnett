Alyssa_Burnett_48997200

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
EXAMPLE OUTPUT:

How many products would you like to retrieve?
3

Please input the Unique ID of the product you would like to retrieve:
69828c5570dcdbd1609216d33fbad0db
69828c5570dcdbd1609216d33fbad0db Pokemon TCG: Sun and Moon Crimson Invasion Elite Trainer Box  $38.49 

Please input the Unique ID of the product you would like to retrieve:
02d72fd06b3342e5b83a2970ae250790
02d72fd06b3342e5b83a2970ae250790 Melissa & Doug Band in a Box & Caterpillar Xylophone Bundle Toys & Games | Kids' Electronics | Electronic Learning Toys $32.68 

Please input the Unique ID of the product you would like to retrieve:
1a22f23576bfdfe5ed6c887dc117aab6
1a22f23576bfdfe5ed6c887dc117aab6 "Remedia Publications REM536B Money Activity Book, Grade: 3 to 4, 8.5"" Wide, 11"" Length, 0.4"" Height" Toys & Games | Learning & Education | Counting & Math Toys $9.31

Process finished with exit code 0

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
TIME COMPLEXITY ANALYSIS:

Insert: O(log N)
Search: O(log N)

This time complexity is due to the nature of Red-Black BSTs, which is to always ensure that the height of the tree is at most O(log N), by consistantly balancing the tree after every Insertion function using the "rules" of Red nodes:

1. All red nodes must be leaning in the same direction (typically to the left), or else they must be "rotated"
2. A single node can only ever have at most ONE red node attached to it at a time, or else the nodes must be "rotated", or their color "flipped", depending on the specific case

The effect of these consistent checks and balances, implies that the speed of performance is dependent on the depth of the tree O(log N).
