import java.util.ArrayList;
import java.util.List;

public class DownloadManager{

    public static void main(String[] args) {

        System.out.println("Thread approach: ");
        List<DownloadableFile1> files1 = new ArrayList<>();

        files1.add(new DownloadableFile1("Document.pdf"));
        files1.add(new DownloadableFile1("Image.jpg"));
        files1.add(new DownloadableFile1("Video.mp4"));

        FileDownloader.downloadFilesUsingThreadApproach(files1);

        System.out.println("Runnable approach: ");
        List<DownloadableFile2> files2 = new ArrayList<>();

        files2.add(new DownloadableFile2("Document.pdf"));
        files2.add(new DownloadableFile2("Image.jpg"));
        files2.add(new DownloadableFile2("Video.mp4"));

        FileDownloader.downloadFilesUsingRunnableApproach(files2);
    }
}

class DownloadableFile1 extends Thread{

    protected String fileName;

    public DownloadableFile1(String fileName ) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for(int i=0 ; i<=100 ; i+=10){
            System.out.println("["+getName()+"] Downloading "+fileName+": "+i+"%");
            try {
                int r = (int)Math.ceil(Math.random()*5);
                sleep(100*r);
            } catch (InterruptedException e) {
                System.out.println("Interruption while dowloading "+fileName+": "+e.getMessage());
            }
        }
    }

}

class DownloadableFile2 implements Runnable{

    protected String fileName;

    public DownloadableFile2(String fileName ) {
        this.fileName = fileName;
    }


    @Override
    public void run() {
        for(int i=0 ; i<=100 ; i+=10){
            System.out.println("["+Thread.currentThread().getName()+"] Downloading "+fileName+": "+i+"%");
            try {
                int r = (int)Math.ceil(Math.random()*5);
                Thread.sleep(100*r);
            } catch (InterruptedException e) {
                System.out.println("Interruption while dowloading "+fileName+": "+e.getMessage());
            }
        }
    }
}

class FileDownloader{

    public static void downloadFilesUsingThreadApproach(List<DownloadableFile1> files){
        int i=1;
        for(DownloadableFile1 file: files){
            file.setName("Thread-"+i);
            i++;
        }
        
        for(DownloadableFile1 file: files){
            file.start();
        }

        for(DownloadableFile1 file: files){
            try {
                file.join();
            } 
            catch (InterruptedException e) {
                System.out.println("Error while downloading: "+e.getMessage());
            }
        }
        System.out.println("All downloads complete!");

    }

    public static void downloadFilesUsingRunnableApproach(List<DownloadableFile2> files){
        List<Thread> threads = new ArrayList<>();
        int i=1;
        for(DownloadableFile2 file: files){
            threads.add(new Thread(file, "Thread-"+i));
            i++;
        }
        
        for(Thread thread: threads){
            thread.start();
        }

        for(Thread thread: threads){
            try {
                thread.join();
            } 
            catch (InterruptedException e) {
                System.out.println("Error while downloading: "+e.getMessage());
            }
        }
        System.out.println("All downloads complete!");

    }
}
