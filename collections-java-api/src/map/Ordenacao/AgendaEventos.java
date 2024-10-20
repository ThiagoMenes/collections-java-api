package map.Ordenacao;
import java.time.LocalDate;
import java.util.*;

public class AgendaEventos {
    //atributo
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos(){
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data,evento);
    }

    public void exibirAgenda(){
        // ao gerar uma TreeMap, os eventos já vão organizados cronologicamente
        Map<LocalDate,Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }
    
    public void obterProximoEvento(){
         LocalDate dataAtual = LocalDate.now();
         LocalDate proximaData = null;
         Evento proximoEvento = null;
         Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
         
         for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O Próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
            }
         }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2024, 7, 15), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 10, 19), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 11, 15), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 9, 12), "Evento 4", "Atração 4");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
