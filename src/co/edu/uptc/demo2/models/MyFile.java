package co.edu.uptc.demo2.models;

import co.edu.uptc.demo2.services.FileUtil;

public class MyFile {    
    private String name;
    private Long size;
    private boolean isDir;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getSize() {
        return size;
    }
    public void setSize(Long size) {
        this.size = size;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean isDir) {
        this.isDir = isDir;
    }
    

    
    @Override
    public String toString() {
        return "MyFile [name=" + name + ",     size=" + size + ",     isDir=" + isDir + "]";
    }
}
