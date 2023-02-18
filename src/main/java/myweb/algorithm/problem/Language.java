package myweb.algorithm.problem;

import lombok.Getter;

@Getter
public enum Language {
    python("language-python"),
    java("language-java"),
    cpp("language-cpp"),
    javascript("language-javascript"),
    sql("language-sql");

    private final String preValue;
    Language(String preValue){
        this.preValue=preValue;
    }
}
