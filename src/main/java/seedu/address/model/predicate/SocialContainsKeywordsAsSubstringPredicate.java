package seedu.address.model.predicate;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

public class SocialContainsKeywordsAsSubstringPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public SocialContainsKeywordsAsSubstringPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> containsSubstringIgnoreCase(person.getSocial().value, keyword));
    }

    private boolean containsSubstringIgnoreCase(String social, String keyword) {
        return social.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SocialContainsKeywordsAsSubstringPredicate)) {
            return false;
        }

        SocialContainsKeywordsAsSubstringPredicate otherSocialContainsKeywordsAsSubstringPredicate
                = (SocialContainsKeywordsAsSubstringPredicate) other;
        return keywords.equals(otherSocialContainsKeywordsAsSubstringPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
