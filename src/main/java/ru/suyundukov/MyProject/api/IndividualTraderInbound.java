package ru.suyundukov.MyProject.api;

import ru.suyundukov.MyProject.entity.IndividualTrader;

import java.util.List;

public interface IndividualTraderInbound {
    IndividualTrader createIndividualTrader(IndividualTrader individualTrader);

    IndividualTrader updateIndividualTrader(Long id, IndividualTrader individualTrader);

    IndividualTrader getIndividualTraderByID(Long id);

    List<IndividualTrader> foundAll();

    void deleteIndividualTrader(Long id);
}
