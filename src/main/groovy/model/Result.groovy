package model

class Result {
    final Winner winner
    final String reason

    Result(Winner winner, String reason) {
        this.winner = winner
        this.reason = reason
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Result result = (Result) o

        if (reason != result.reason) return false
        if (winner != result.winner) return false

        return true
    }

    int hashCode() {
        int result
        result = (winner != null ? winner.hashCode() : 0)
        result = 31 * result + (reason != null ? reason.hashCode() : 0)
        return result
    }
}
