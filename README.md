# HStoneApp
Este repositório consiste na implementação de uma aplicação Android, utilizando a linguagem Kotlin, que consome a API pública do Hearthstone(https://swapi.dev/api/](https://rapidapi.com/omgvamp/api/hearthstone), onde lista 7 categorias, sendo: Classes, Sets, Types, Factions, Qualities, Races e Locales, também é possivel fazer a busca das cartas dos personagens clicando na categoria escolhida.

### Especificações Técnicas ✔️
SDK (Versão Mínima): 27
</br>SDK (Versão Alvo): 34
</br>Arquitetura: MVVM + Clean Architecture
### Bibiliotecas utilizadas ✔️
Retrofit (Usado para comunicação da API REST)
</br>Coil (Carregamento de imagens)
</br>Koin (Injeção de Dependências)
</br>Coroutines (Como um padrão de design de simultaneidade para simplificar o código executado de forma assíncrona)
</br>StateFlow (Para programação de estilo reativo (de VM para UI))
Entre outras.
### Testes Unitários ✔️
Para os testes Unitários, foi utilizado JUnit4 e MockK sendo realizado testes da ViewModel, Use Case e Reposistory.
### Melhorias futuras ✔️
Componentização
</br>Testes de UI
</br>Modularização
