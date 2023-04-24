package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;

    private SelectItem selected;

    public static final List<SelectItem> listAutoComplete = List.of(
        new SelectItem( 1,"Item 1"), new SelectItem(2, "Item 2"),
        new SelectItem( 3,"Item 11"), new SelectItem(4, "Item 22"));
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
    }

    public List<SelectItem> complete(String query) {
        String queryLowerCase = query.toLowerCase();
        return listAutoComplete.stream().filter(selectItem -> selectItem.getLabel().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    @Data @AllArgsConstructor
    public static class SelectItem implements Serializable {
        private int id;
        private String label;
    }

}
