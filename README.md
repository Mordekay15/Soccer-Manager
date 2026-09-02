# Soccer Manager

An Android app for browsing soccer **players**, **teams**, and **matches**. Built in Java, it demonstrates clean use of generics, the Iterator design pattern, and predicate-based (lambda) filtering over a `RecyclerView`.

## Features

- Browse a combined list of players, teams, and matches
- Filter the list by type (All / Players / Teams / Matches)
- Live text filtering - narrow players/matches by team, or teams by league
- Custom iterators for each entity type (Iterator pattern demo)
- Generic `Repository<T>` with `Predicate`-based filtering

## Tech Stack

- **Language:** Java
- **Platform:** Android (min SDK 26, target SDK 34, compile SDK 35)
- **UI:** AndroidX AppCompat, Material Components, ConstraintLayout, RecyclerView
- **Build:** Gradle (Kotlin DSL)

## Architecture

The project is organized around a few small, focused packages:

| Package | Responsibility |
|--------|----------------|
| `model` | Domain entities - `Player`, `Team`, `Match`, all implementing the `SoccerEntity` interface |
| `container` | `Repository<T>` (generic storage + filtering), per-type repositories, and custom iterators (`PlayerIterator`, `TeamIterator`, `MatchIterator`) |
| `adapter` | `RepositoryAdapter` and `RepositoryViewHolder` for binding entities to the `RecyclerView` |
| (root) | `MainActivity` - wires everything together and handles UI events |

### Design patterns used

- **Iterator** - `CustomIterator<T>` interface with dedicated iterators per entity type
- **Strategy / Predicate filtering** - `Repository.filter(Predicate<T>)` using Java 8 lambdas and streams
- **Generics** - a single reusable `Repository<T>` across all entity types

## Getting Started

### Prerequisites

- Android Studio (Giraffe or newer recommended)
- JDK 11
- An Android emulator or device running API 26+

### Build & Run

```bash
# Clone the repository
git clone https://github.com/mordekay15/soccer-manager.git
cd soccer-manager

# Build a debug APK
./gradlew assembleDebug

# Or install directly to a connected device/emulator
./gradlew installDebug
```

You can also simply open the project in Android Studio and press **Run ▶**.

## Usage

- Tap **Show All** to see every entity.
- Tap **Players**, **Teams**, or **Match** to filter by type — a text box appears for further filtering (by team or league).
- Tap **Custom Iterator** to run the iterator demo (results are printed to the log via `System.out`).
- Tap any item to see its name in a toast.

## Project Structure

```
app/
└── src/main/java/com/example/week11/
    ├── MainActivity.java
    ├── model/          # Player, Team, Match, SoccerEntity
    ├── container/      # Repository, repositories, iterators, DataProvider
    └── adapter/        # RecyclerView adapter + view holder
```

## License

This project is provided for educational purposes. Add a license of your choice here.
