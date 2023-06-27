package QLTL.manage;

import QLTL.document.Document;

public interface IManageDocument {
    void addDocument(Document document);
    void deleteById(String id);
    void showAll();
    void showAllByType(String type);
}
