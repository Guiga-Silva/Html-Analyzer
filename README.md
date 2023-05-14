# HtmlAnalyzer

## Resumo
    
### O __HtmlAnalyzer__ é um programa em Java que analisa uma página HTML, no qual, passado uma URL, é retornado o trecho de texto em que está contido no maior número de tags. Além disso, o programa é capaz de analizar se nenhum argumento foi passado no terminal, se realmente foi possível obter o conteúdo em HTML caso a conexão não tenha sido interrompida e se a estrutura HTML está mal-formada. Com isso, caso essas verificações falhem o programa será encerrado e mostrado ao usuário o que foi ocorrido.

<br>

## Como Executar

### Primeiramente para compilar o programa, deve-se estar no mesmo diretório que o arquivo __HtmlAnalyzer.java__ e executar a seguinte linha de comando no terminal:
```
javac HtmlAnalyzer.java
```

### Em seguida, para executar o programa, ainda no mesmo diretório, deve-se executar o seguinte comando, substituindo __<__url__>__ pela URL a ser utilizada:
```
java HtmlAnalyzer.java <url>
```
