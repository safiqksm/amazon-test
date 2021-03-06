package amazontest;

/*
Amazon wants to implement a new backup system, in which files are stored into data tapes.
 
This new system must follow the following 2 rules:
	1. Never place more than two files on the same tape.
	2. Files cannot be split across multiple tapes.
	
It is guaranteed that all tapes have the same size and that they will always be able to store the largest file.
Every time this process is executed, we already know the size of each file, and the capacity of the tapes. 
Having that in mind, we want to design a system that is able to count how many tapes will be required to store the backup in the most efficient way.
The parameter of your function will be a structure that will contain the file sizes and the capacity of the tapes. 
You must return the minimum amount of tapes required to store the files.

You can write any methods or classes you would like. However, all new classes must be written in this 
file and you cannot change the BackupSystem class name, the Batch interface contract or the getMinimumTapeCount() method signature.

Example:
--------
	Input: Tape Size = 100; Files: 70, 10, 20
	Output: 2
	
*/
public class BackupSystem {

	public interface Batch {
	    int[] getFileSizes();
	    int getTapeSize();
	}
	
	public static class BatchImpl implements Batch {
		
		int tapeSize;
		int files[];
		
		public BatchImpl(int tapeSize, int files[]) {
			this.tapeSize = tapeSize;
			this.files = files;
		}

		@Override
		public int[] getFileSizes() {
			return files;
		}

		@Override
		public int getTapeSize() {
			return tapeSize;
		}
		
	}

	public int getMinimumTapeCount(final Batch batch) {
		int minimumTapeCount = 0;
		int maximumFileSize = 0;
		
		
		for (int fileSize : batch.getFileSizes()) {
			maximumFileSize += fileSize;
		}
		
		while (batch.getTapeSize() <= maximumFileSize) {
			
			if (batch.getTapeSize() == maximumFileSize) {
				minimumTapeCount += 2;
				maximumFileSize -= maximumFileSize;
			}
			
			if (batch.getTapeSize() < maximumFileSize) {
				maximumFileSize -= maximumFileSize;
				minimumTapeCount += 1;
			}
		}
		
		return minimumTapeCount;
	}
	
	public static void main(String[] args) {
		Batch batch = new BatchImpl(100, new int[]{70, 10, 20});
		
		System.out.println(new BackupSystem().getMinimumTapeCount(batch));
	}

}
