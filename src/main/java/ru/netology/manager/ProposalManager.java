package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Proposal;
import ru.netology.repository.ProposalRepository;
import java.util.Arrays;
import java.util.Comparator;

@NoArgsConstructor
@Data
public class ProposalManager {
    private ProposalRepository repository;

    public ProposalManager(ProposalRepository repository) {
        this.repository = repository;
    }

    public Proposal[] searchBy(String out, String in) {
        Proposal[] result = new Proposal[0];
        for (Proposal proposal : repository.getAll()) {
            if (matches(proposal, out, in)) {
                Proposal[] tmp = new Proposal[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = proposal;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Proposal[] searchBy(String out, String in, Comparator<Proposal> comparator) {
        Proposal[] result = new Proposal[0];
        for (Proposal proposal : repository.getAll()) {
            if (matches(proposal, out, in)) {
                Proposal[] tmp = new Proposal[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = proposal;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(Proposal product, String out, String in) {
        if (product.getFrom().contains(out) & product.getTo().contains(in)) {
            return true;
        }
        return false;
    }
}