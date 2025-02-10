package stusyo222b.appz_4.factory;


public enum FileType {
    TXT("txt"),
    JSON("json"),
    XML("xml");

    private String extension;

    // Конструктор для инициализации перечисления
    FileType(String extension) {
        this.extension = extension;
    }

    // Геттеры для расширения и описания
    public String getExtension() {
        return extension;
    }


    // Метод для получения всех расширений в виде массива
    public static FileType[] getAllFileTypes() {
        return FileType.values();
    }
}
