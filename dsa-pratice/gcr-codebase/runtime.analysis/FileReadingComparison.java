package runtime.analysis;

import java.io.*;

/**
 * Problem Statement 4: Large File Reading Efficiency
 * Compare FileReader (Character Stream) vs InputStreamReader (Byte Stream)
 */
public class FileReadingComparison {

    // Create a test file with specified size (in MB)
    public static void createTestFile(String filename, int sizeMB) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            int bytesPerLine = 100;
            int lines = (sizeMB * 1024 * 1024) / bytesPerLine;

            for (int i = 0; i < lines; i++) {
                writer.write("This is a test line for file reading performance comparison. Line number: " + i + "\n");
            }
        }
    }

    // Read file using FileReader (character stream)
    public static long readWithFileReader(String filename) throws IOException {
        long charCount = 0;
        try (FileReader reader = new FileReader(filename)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                charCount++;
            }
        }
        return charCount;
    }

    // Read file using BufferedReader with FileReader
    public static long readWithBufferedFileReader(String filename) throws IOException {
        long charCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                charCount += line.length();
            }
        }
        return charCount;
    }

    // Read file using InputStreamReader (byte stream)
    public static long readWithInputStreamReader(String filename) throws IOException {
        long charCount = 0;
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filename))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                charCount++;
            }
        }
        return charCount;
    }

    // Read file using BufferedReader with InputStreamReader
    public static long readWithBufferedInputStreamReader(String filename) throws IOException {
        long charCount = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                charCount += line.length();
            }
        }
        return charCount;
    }

    // Performance comparison
    public static void comparePerformance(int[] fileSizesMB, String tempDir) {
        System.out.println("=== File Reading Performance Comparison ===\n");
        System.out.printf("%-12s %-20s %-25s %-25s %-30s%n",
            "File Size", "FileReader", "Buffered FileReader",
            "InputStreamReader", "Buffered InputStreamReader");
        System.out.println("-".repeat(110));

        for (int sizeMB : fileSizesMB) {
            String filename = tempDir + "/testfile_" + sizeMB + "MB.txt";

            try {
                // Create test file
                System.out.print("Creating " + sizeMB + "MB test file... ");
                createTestFile(filename, sizeMB);
                System.out.println("Done");

                // FileReader timing (skip for large files)
                String fileReaderTime;
                if (sizeMB <= 10) {
                    long startTime = System.nanoTime();
                    readWithFileReader(filename);
                    long elapsed = System.nanoTime() - startTime;
                    fileReaderTime = formatTime(elapsed);
                } else {
                    fileReaderTime = "Skipped";
                }

                // Buffered FileReader timing
                long startTime = System.nanoTime();
                readWithBufferedFileReader(filename);
                long bufferedFileReaderTime = System.nanoTime() - startTime;

                // InputStreamReader timing (skip for large files)
                String inputStreamReaderTime;
                if (sizeMB <= 10) {
                    startTime = System.nanoTime();
                    readWithInputStreamReader(filename);
                    long elapsed = System.nanoTime() - startTime;
                    inputStreamReaderTime = formatTime(elapsed);
                } else {
                    inputStreamReaderTime = "Skipped";
                }

                // Buffered InputStreamReader timing
                startTime = System.nanoTime();
                readWithBufferedInputStreamReader(filename);
                long bufferedInputStreamReaderTime = System.nanoTime() - startTime;

                System.out.printf("%-12s %-20s %-25s %-25s %-30s%n",
                    sizeMB + " MB",
                    fileReaderTime,
                    formatTime(bufferedFileReaderTime),
                    inputStreamReaderTime,
                    formatTime(bufferedInputStreamReaderTime));

                // Clean up
                new File(filename).delete();

            } catch (IOException e) {
                System.err.println("Error processing file: " + e.getMessage());
            }
        }
    }

    private static String formatTime(long nanos) {
        if (nanos < 1000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.2f µs", nanos / 1000.0);
        } else if (nanos < 1_000_000_000) {
            return String.format("%.2f ms", nanos / 1_000_000.0);
        } else {
            return String.format("%.2f s", nanos / 1_000_000_000.0);
        }
    }

    public static void main(String[] args) {
        int[] fileSizes = {1, 5, 10, 50};
        String tempDir = System.getProperty("java.io.tmpdir");

        comparePerformance(fileSizes, tempDir);

        System.out.println("\n📊 Analysis:");
        System.out.println("- Unbuffered readers are significantly slower for large files");
        System.out.println("- BufferedReader dramatically improves performance");
        System.out.println("- For text files, BufferedReader with FileReader is efficient");
        System.out.println("- InputStreamReader is more flexible for different encodings");
        System.out.println("\n💡 Recommendation:");
        System.out.println("- Always use BufferedReader for file reading");
        System.out.println("- Use FileReader for simple text files");
        System.out.println("- Use InputStreamReader when you need encoding control");
    }
}
