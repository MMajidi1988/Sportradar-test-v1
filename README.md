# Live Football World Cup Scoreboard

A simple in-memory Java library for managing live football matches and producing a sorted summary of matches in progress.

## Requirements implemented

- Start a new match with initial score `0-0`
- Update score using absolute values
- Finish a match in progress
- Get summary ordered by:
  1. Total score descending
  2. If same total score, most recently started match first

## Tech stack

- Java 21
- Gradle
- JUnit Jupiter (JUnit 5)

## Run tests

```powershell
.\gradlew.bat test


## Project structure

- `lib/src/main/java/com/mmaji/scoreboard` - library implementation
- `lib/src/test/java/com/mmaji/scoreboard` - unit tests

## Assumptions

- Matches are identified by `(homeTeam, awayTeam)`.
- Updating or finishing a non-existing match throws `IllegalArgumentException`.
- The solution is in-memory only (no database, no REST API).

## Development approach

The solution was built incrementally using TDD (red/green/refactor) with small, focused commits.