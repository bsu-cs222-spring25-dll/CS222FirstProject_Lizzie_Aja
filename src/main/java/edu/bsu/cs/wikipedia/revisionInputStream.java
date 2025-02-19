package edu.bsu.cs.wikipedia;

import edu.bsu.cs.Execeptions.openInputStreamException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

//inspired by Nolan Meyer and Dakota Coughlin
public class revisionInputStream {
    protected byte[] inputStream;

    public revisionInputStream(InputStream inputStream) throws openInputStreamException {
        try {
            this.inputStream = inputStream.readAllBytes();
        } catch (Exception e) {
            throw new openInputStreamException();
        }
    }

    public ByteArrayInputStream openInputStream() {
        return new ByteArrayInputStream(inputStream);
    }
}


