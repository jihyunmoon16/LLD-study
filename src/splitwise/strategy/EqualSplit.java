package splitwise.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import splitwise.model.Expense;
import splitwise.model.User;

public class EqualSplit implements SplitStrategy {

	@Override
	public Map<User, Double> split(Expense expense) {
		List<User> participants = expense.getParticipants();

		double share = expense.getAmount() / participants.size();

		Map<User, Double> result = new HashMap<>();
		for(User user : participants) {
			result.put(user, share);
		}
		return result;
	}
}
