class Gangs {
	constructor(){
		this.compositeGang = 0;
		this.primeGang = 0;
	}
	
	main(input) {
	    var lines = input.split("\n");
	    var t = Number(lines[0]);
		var arr = [];
        for (var x = 1; x < lines.length; x++) {
			var rowColumns = lines[x];
			var rowColumnsSep = rowColumns.split(" ");
			var rows = rowColumnsSep[0];
			var columns = rowColumnsSep[1];
			for (let index = x+1; index < x+1+rows; index++,x++) {
				var cols = lines[index].split(' ');
				arr[index] = [];
				for (let jndex = 0; jndex < cols; jndex++) {
					arr[index][jndex] = cols[jndex];
				}
			}
			process.stdout.write(arr);
			var array = [];
			for (var i = 0; i < rows; i++) {
				array[i] = [];
				for (var j = 0; j < columns; j++) {
					var number = arr[i][j];
					var isPrime = this.isPrimeNumber(number);
					array[i][j] = new Node(number,isPrime);
				}
			}
			
			
		
			this.checkForCompositeGangs(array,rows,columns);
			console.log(this.primeGang+' '+this.compositeGang);
        }
		

	}

	checkForCompositeGangs(array, rows, columns) {
		var checkFor = null;
		var checkList = [];
		for (var i = 0; i < rows; i++) {
			for (var j = 0; j < columns; j++) {
				var node = array[i][j];
				if(node !== null) {
					var isPrime = node.isPrime;
					if(checkFor === null) {
						checkFor = isPrime;
					}
					if(checkFor === isPrime) {
						node.checked = true;
						checkList.push(i+","+j);
						this.checkForEight(array,checkFor,checkList,rows,columns);
					}
					if(checkFor === true) {
						this.primeGang++;
					}else {
						this.compositeGang++;
					}
					if(checkFor !== null) {
						this.doNull(array,rows,columns);
						this.checkForCompositeGangs(array,rows,columns);
					}
				}
			}
		}
	}

	doNull(array,rows,columns) {
		for (var i = 0; i < rows; i++) {
			for (var j = 0; j < columns; j++) {
				var node = array[i][j];
				if(node !== null && node.checked) {
					array[i][j] = null;
				}
			}
		}
	}

	checkForEight(array,checkFor,checkList,rows,columns) {
		for (var k = 0; k < checkList.length; k++) {
			var i = parseInt(checkList[k].split(",")[0]);
			var j = parseInt(checkList[k].split(",")[1]);
			var node;
			var number;
			if(i-1 >= 0 && j >= 0 && array[i-1][j] !== null) {
				node = array[i-1][j];
				if(checkFor == node.isPrime && !node.checked) {				
					node.checked = true;
					number = (i-1)+","+(j);
					if(checkList.indexOf(number) === -1) {
						checkList.push(number);
					}
				}
			}
			if(i >= 0 && j-1 >= 0 && array[i][j-1] !== null) {
				node = array[i][j-1];
				if(checkFor === node.isPrime && !node.checked) {				
					node.checked = true;
					number = (i)+","+(j-1);
					if(checkList.indexOf(number) === -1) {
						checkList.push(number);
					}
				}
			}
			if(i >= 0 && j+1 < columns && array[i][j+1] !== null) {
				node = array[i][j+1];
				if(checkFor == node.isPrime && !node.checked) {				
					node.checked = true;
					number = (i)+","+(j+1);
					if(checkList.indexOf(number) === -1) {
						checkList.push(number);
					}
				}
			}
			if(i+1 < rows && j >= 0 && array[i+1][j] !== null) {
				node = array[i+1][j];
				if(checkFor === node.isPrime && !node.checked) {
					node.checked = true;
					number = (i+1)+","+(j);
					if(checkList.indexOf(number) === -1) {
						checkList.push(number);
					}
				}
			}
			checkList = checkList.filter(obj => obj !== i+","+j);
			if(checkList.length !== 0) {
				this.checkForEight(array,checkFor,checkList,rows,columns);
			}
		}
	}

	isPrimeNumber(number) {
		if(number === 2) {
			return true;
		}
		if(number % 2 === 0) {
			return false;
		}
		for (var i = 2; i < number/2+1; i++) {
			if(number % i === 0) {
				return false;
			}
		}
		return true;
	}
}

class Node{
	constructor(number,isPrime) {
		this.number= number;
		this.isPrime = isPrime;
		this.checked = false;
	}
}

process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function(input) {
  stdin_input += input;
});

process.stdin.on("end", function() {
    var gangs = new Gangs();
    gangs.main(stdin_input);
});