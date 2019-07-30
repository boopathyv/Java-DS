# Linear Search => sequential search

| Complexity       | Best Case | Average Case | Worst Case |
|------------------|-----------|--------------|------------|
| Time             | O(1)      | O(n)         | O(n)       |
| Space Complexity |           |              | O(1)       |

# Binary Search
|         Performance           |Complexity|
|-------------------------------|----------|
|1	Worst case	                |O(log n)  |
|2	Best case					|O(1)      |
|3	Average Case				|O(log n)  |
|4	Worst case space complexity	|O(1)      |

# Bubble Sort (tick)

=> each loop the highest element is moved to lastIndex
=> in each loop n-1 elements are traversed

|         Scenario	            | Complexity |
|-------------------------------|------------|
|          Space	            |    O(1)    |
|    Worst case running time	|    O(n2)   |
|   Average case running time	|    O(n)    |
|    Best case running time	    |    O(n2)   |

# Selection Sort (tick)
=> select the smallest number in an array an swap to its corresponding index

* Worst Case Time Complexity [ Big-O ]: O(n2)

* Best Case Time Complexity [Big-omega]: O(n2)

* Average Time Complexity [Big-theta]: O(n2)

* Space Complexity: O(1)

# Bucket Sort (tick)
Bucket sort is also known as bin sort. It works by distributing the element into the array also called buckets. Buckets are sorted individually by using different sorting algorithm

##### NOTE:
> * take highest num in an array;
> * take 0 to 9 buckets
> * find divider = ceil(highNum+1/10) ===> if value is 8.2 => 9 / 8.7 => 9
> * divide each element = floor(element/divider) ===> if value is 8.2 => 8 / 8.7 => 8
> * put in buckets
> * sort the buckets. print the numbers from the bucket 0 - 9 in order



|			Algorithm        	| Complexity |
|-------------------------------|------------|
|			Space				|	O(1)	 |
|		  Worst Case			|	O(n2)	 |
|		  Best Case				|	Ω(n+k)	 |
|		 Average Case			|	θ(n+k)	 |

# Insertion Sort (tick)
This is exactly how insertion sort works. It starts from the index 1(not 0), 
and each index starting from index 1 is like a new card, 
that you have to place at the right position in the sorted subarray on the left.

|			Complexity			|	Best Case	|	Average Case	|	Worst Case	|
|-------------------------------|---------------|-------------------|---------------|
|				Time			|	   Ω(n)		|		θ(n2)		|		o(n2)	|
|				Space			|				|					|		o(1)	|

# Merge Sort => Divide and Conquer(Rule) Method
## NOTE : All major work is done when merging
Worst Case Time Complexity [ Big-O ]: O(n*log n)

Best Case Time Complexity [Big-omega]: O(n*log n)

Average Time Complexity [Big-theta]: O(n*log n)

Space Complexity: O(n)

# Quick Sort => Also called partition-exchange sort
## NOTE : It is similar like MergeSort.But All major work is done when dividing
Worst Case Time Complexity [ Big-O ]: O(n2)

Best Case Time Complexity [Big-omega]: O(n*log n)

Average Time Complexity [Big-theta]: O(n*log n)

Space Complexity: O(n*log n)

# Heap Sort => (https://www.studytonight.com/data-structures/heap-sort)
## watch this => (https://www.youtube.com/watch?v=51JGP4VVlDc)
1) Shape Property: Heap data structure is always a Complete Binary Tree, which means all levels of the tree are fully filled.
2) Heap Property: All nodes are either greater than or equal to or less than or equal to each of its children. If the parent nodes are greater than their child nodes, heap is called a Max-Heap, and if the parent nodes are smaller than their child nodes, heap is called Min-Heap.

	Worst Case Time Complexity: O(n*log n)

	Best Case Time Complexity: O(n*log n)

	Average Time Complexity: O(n*log n)

	Space Complexity : O(1)
	
# Radix Sort
-> take buckets... 0->9
pass each digit from right of each number
no.of passes = no. of digits of the highest number in the array
# Shell Sort => it is like INSERTION SORT
> * consider a GAP value and compares it.
> * the gap keeps on reducing is comparison is failed 