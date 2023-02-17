import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileIterator implements Iterator<String> {
    private String path;
    private BufferedReader reader;
    private String nextLine = null;

    public FileIterator(String path) throws FileNotFoundException {
        this.path = path;
        File file = new File(path);
        FileReader fr = new FileReader(file);
        this.reader = new BufferedReader(fr);
    }

    @Override
    public boolean hasNext() {
        if (nextLine != null) {
            return true;
        } else {
            try {
                this.nextLine = this.reader.readLine();
                return (nextLine != null);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    @Override
    public String next() {
        if (nextLine != null || hasNext()) {
            String line = nextLine;
            nextLine = null;
            return line;
        } else {
            throw new NoSuchElementException();
        }
    }


}