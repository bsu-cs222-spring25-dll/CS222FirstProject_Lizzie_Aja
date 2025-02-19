package edu.bsu.cs.wikipedia;
import edu.bsu.cs.Execeptions.openInputStreamException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class revisionInputStreamTest {
    //inspired by Nolan Meyer and Dakota Coughlin
    @Test
    public void returnsInputStreamTest() throws openInputStreamException {
        InputStream sampleFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
        revisionInputStream revisionInputStream = new revisionInputStream(sampleFile);
        assertInstanceOf(ByteArrayInputStream.class, revisionInputStream.openInputStream());
    }
}
