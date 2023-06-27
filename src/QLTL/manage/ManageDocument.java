package QLTL.manage;

import QLTL.document.Document;

import java.util.Arrays;

public class ManageDocument implements IManageDocument {
    private Document[] documents = {};

    @Override
    public void addDocument(Document document) {
        this.documents = Arrays.copyOf(this.documents, this.documents.length + 1);
        this.documents[this.documents.length - 1] = document;
    }

    @Override
    public void deleteById(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            Document[] newDocument = new Document[documents.length];
            for (int i = 0; i < newDocument.length; i++) {
                newDocument[i] = i < index ? documents[i] : documents[i + 1];
            }
            documents = newDocument;
        }
    }

    private int findIndexById(String id) {
        for (int i = 0; i < documents.length; i++) {
            if (documents[i].getId().equals(id)) return i;
        }
        return -1;
    }

    @Override
    public void showAll() {
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    @Override
    public void showAllByType(String type) {
        for (Document document : documents) {
            if (document.getId().contains(type)) {
                System.out.println(document);
            }
        }
    }
}
