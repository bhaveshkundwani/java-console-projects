# Online Movie Ticket Booking System (Java)

A Java project that models an online movie ticket booking system: browsing
movies, managing theaters and showtimes, and booking tickets for a
specific movie at a specific time and place.

This is a project in my java-console-projects repository.

## Working of the System

- **Movies** are stored with a name, genre, and duration.
- **Theaters** have a name, a location, and a set of showtimes.
- **Showtimes** tie a specific movie to a specific date/time at a theater,
  and track whether that slot is still available.
- **Bookings** record who booked a ticket, for which movie, at which showtime.

The system supports:

- Browsing the list of movies
- Searching for movies by name
- Sorting movies alphabetically by name
- Adding theaters and attaching showtimes to them
- Searching for showtimes by movie and theater
- Booking a ticket for an available showtime

## Project Structure

```
06-Online-Movie-Ticket-System/
├── README.md
└── src/
    └── com/
        └── movieticketbooking/
            ├── Movie.java                       # A movie: name, genre, duration
            ├── Theater.java                     # A theater: name, location, showtimes
            ├── Showtime.java                    # A movie + date/time + availability
            ├── Booking.java                     # A confirmed booking: movie, showtime, customer
            └── MovieTicketBookingSystem.java    # Main class — ties everything together
```

## Key Concepts Used

- **`Comparable<Movie>`** – Gives movies a natural sort order (alphabetical by name), used by `Collections.sort()`.
- **`equals()` / `hashCode()`** – Overridden on `Movie`, `Theater`, and `Showtime` so they behave correctly in `Set`s and `Map` keys.
- **Concurrent collections** – `CopyOnWriteArrayList`, `CopyOnWriteArraySet`, and `ConcurrentHashMap` are used so the system is safe to use from multiple threads.
- **`java.time.LocalDateTime`** – Represents showtime dates and times.
- **Collections framework** – `List`, `Set`, and `Map` model movies, theaters, and their relationships.

## Sample Output

```
Booking successful for Bhavesh
Search Results: [Movie{name='Inception', genre='Sci-Fi', duration=148}]
Sorted Movies: [Movie{name='Inception', genre='Sci-Fi', duration=148}, Movie{name='The Dark Knight', genre='Action', duration=152}]
```

### Booking an unavailable showtime

If a showtime has already been booked, trying to book it again is handled
gracefully instead of throwing an error:

```
Sorry, this showtime is unavailable.
```

## Notes

- `searchMoviesByName()` matches on a **case-sensitive substring**, so
  searching `"inception"` (lowercase) won't match `"Inception"`.
- Each `Theater` maps to its own list of showtimes in
  `theaterShowtimes` — showtimes must be added to a theater with
  `addShowtimeToTheater()` before they can be searched or booked.
- Data isn't persisted — everything exists only in memory for the
  lifetime of the program.