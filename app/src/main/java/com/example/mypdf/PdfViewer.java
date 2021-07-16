package com.example.mypdf;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PdfViewer extends AppCompatActivity {

    PDFView pdfView;
    String path="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        pdfView = findViewById(R.id.pdfViewer);
        path = getIntent().getStringExtra("path");

        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        pdfView.fromUri(uri).load();

    }
}