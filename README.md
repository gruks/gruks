# JavaFX POS Theme Demo

This sample shows how to design an FXML view with CSS that reads colors from a backend and applies them dynamically at runtime.

## Run

You need Java 17+ and Gradle (or use the Gradle wrapper in your environment).

- Start a simple theme endpoint locally:

```bash
python3 -m http.server 8080 &>/dev/null &
# Or use any server that returns JSON at /theme
```

Expected JSON at `http://localhost:8080/theme`:

```json
{
  "primary": "#2563eb",
  "secondary": "#16a34a",
  "background": "#0b1220",
  "text": "#e5e7eb"
}
```

- Run the app:

```bash
./gradlew run -Dtheme.url=http://localhost:8080/theme
```

If Gradle is not installed, install it or run with the wrapper if available.

## How it works
- Looked-up CSS colors are defined in `src/main/resources/theme.css` using variables like `-color-primary`.
- `ThemeService` fetches colors from the backend.
- `ThemeApplier` sets style variables on the scene root, which immediately updates all styled nodes.
- `MainController` includes a "Fetch Theme" button to re-apply on demand.
