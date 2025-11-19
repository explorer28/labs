//music: name, copies sold, download (yes / no)
//count all sold, can download
import java.util.*;

public class lab4{
	public static void main(String[] args){
		Music music_array [] = new Music[10];

		for(int index = 0; index < music_array.length; index++){
            music_array[index] = new Music(index+1, "Music N" + index+1, 15000, false); //!!!
            music_array[index].printRecord();
        }

		int allCopiesSold=0, canDownloadCount=0;

		for(Music example : music_array){
			allCopiesSold+=example.getCopiesSold();
			if(example.canDownload)canDownloadCount++;
		}
		System.out.println("\nCopies sold of all music count:" + allCopiesSold + "\nAvailable to download: " + canDownloadCount);
	}
}

public class Music{

    protected int musicIndex;
	protected String name;
	protected int copiesSold;
	protected boolean canDownload;
	
	Music(){
        this.musicIndex = 0;
		this.name = "";
		this.copiesSold = 0;
		this.canDownload = false;
	}
	Music(int musicIndex, String name, int copiesSold, boolean canDown){
		this.musicIndex = musicIndex >= 0 ? musicIndex : -1;
		this.copiesSold = copiesSold >= 0 ? copiesSold : -1;
		this.canDownload = canDownload;

	}
	public int getCopiesSold(){
		return this.copiesSold;
	}
	public boolean canDownload(){
		return this.canDownload;
	}
	public void printRecord(){
		System.out.println("\nMusic:\nMusic Index: " +  this.musicIndex + "\nName: " + name + "\nCopies sold: " + copiesSold + "\nAvailable to download: " + canDownload);
	}
}