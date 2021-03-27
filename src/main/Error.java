package main;

public enum Error {
	NOFILEARG {
		@Override
		public String toString() {
			return "No argument supplied for input file";
		}
	},
	TOOMANYFILEARGS {
		@Override
		public String toString() {
			return "Too many arguments given";
		}
	},
	FILENOTFOUND {
		@Override
		public String toString() {
			return "Input file not found! Please make sure you it is the same folder as the run.sh script";
		}
	},
	INVALIDFORMATTING {
		@Override
		public String toString() {
			return "The formatting of the input text file was incorrect. The format should be as seen below\n"
					+ "<Item 1><tab><Price of Item 1><tab><Consumer 1>,<Consumer 2>,<Consumer 3>\n"
					+ "See exampleInputFile.txt to see an example of how the text file should be formatted";
		}
	}
	;
	public void printErrorMessage() {
		System.out.println("There was an Error!!! See below for more information");
		System.out.println(this.toString());
	}
}
