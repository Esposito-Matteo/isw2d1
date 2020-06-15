[![Build Status](https://travis-ci.com/Esposito-Matteo/isw2d1.svg?branch=master)](https://travis-ci.com/Esposito-Matteo/isw2d1) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Esposito-Matteo_isw2d1&metric=code_smells)](https://sonarcloud.io/dashboard?id=Esposito-Matteo_isw2d1)

# Software Engeneering II

# Content of this repository
* Java Source Code
* Logger configurations file
* Dependecies

## Deliverable #1

Lo scopo della prima deliverable, così come espresso dalle specifiche nel materiale del corso, è incentrata nella raccolta incrociata e plot di dati presenti sulle piattaforme GitHub e Jira su di una specifica metrica al fine di formulare osservazioni sullo statistical process control.  Lo Statistical process control in lingua inglese o controllo statistico di processo è l'applicazione di un metodo matematico o statistico che consente di contenere l'esito di un processo all'interno di specifici limiti, determinati attraverso lo studio della variazione naturale dei limiti del processo.
Uno dei principali metodi statistici applicabili è la rilevazione dello scarto quadratico medio, detto anche deviazione standard. Attraverso la correlazione tra questo valore e la distribuzione normale dei dati rilevati si ottengono i limiti naturali della variazione di un processo.
Un processo viene poi classificato in base all'esito dell'osservazione che ne deriva in due categorie:

- sotto controllo statistico, quando è influenzato unicamente da fattori casuali, cioè da "madre natura"
- fuori controllo statistico, quando l'influenza delle sue variazioni è causata da fattori specifici.

In particolare, se un processo è sotto controllo statistico, l'osservazione del suo andamento nel tempo, effettuando un campionamento di dati, seguirà una distribuzione di frequenza che sarà molto simile a una distribuzione normale. Questo implica che l'analisi del processo dal punto di vista della media e della sua variabilità sia fondamentale per determinare i "limiti naturali" del processo, entro i quali, se non accadono cause specifiche, il processo manterrà il proprio andamento. Viceversa, una volta studiato un processo che si mantiene entro certi limiti con una distribuzione di probabilità ben definita, quando questa distribuzione cambia, oppure cambiano i limiti, si può pensare ragionevolmente dal punto di vista statistico che stia agendo una "possibile causa di fuori controllo". Nello specifico, le specifiche prevedono di:

-	misurare la stabilità del numero di fixed bugs del progetto Eagle, realizzando un process control chart;
-	individuare eventuali periodi di instabilità   relativamente al numero di fixed bugs e cercare di identificare le possibili cause di tale comportamento ed eventuali soluzioni da adottare in futuro;
-	determinare se il processo può essere considerato stabile (stable) in relazione all’attributo studiato.


