
# ClickyHeroApp

ClickyHeroApp is an Android application designed as a clicker game where users tap the screen to earn points, defeat enemies, and unlock upgrades. The game is inspired by the popular incremental/clicker genre, providing an engaging and rewarding gameplay experience.

## Features
- **Button Tap Sequence Challenge:** Users are presented with a series of button tap sequences that they must repeat in the correct order.
- **Predefined Combinations:** The app contains a hard-coded list of 5 combinations, each containing between 4 and 8 button presses, with colorful names.
- **Randomized Display:** The combinations are displayed in a random order within a RecyclerView.
- **Combo Attempt Activity:** Upon selecting a combo, users are taken to a new activity to attempt the sequence, using ImageViews and ImageButtons.
- **Tap Feedback:** Each tap updates the display to show a correct (gold star) or incorrect (grey star) result.
- **Completion and Congratulation:** Once all combinations are attempted, the app shows a "Congratulations" screen with a success message and the number of correct combinations.
- **Restart Option:** Users can restart the game to randomize the order and reset the correct count, available only on the main screen, not during combo or congratulations activities.
- **Visual Feedback:** The app uses colorful indicators for unattempted, correct, and incorrect combinations.
- **Modern UI:** Clean and intuitive interface with structured navigation.

## Installation
To set up the project locally:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ViSadhu/ClickyHeroApp.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd ClickyHeroApp
   ```

3. **Open the project in Android Studio:**
   - Ensure you have the latest version of [Android Studio](https://developer.android.com/studio) installed.
   - Open the project by selecting the `ClickyHeroApp` directory.

4. **Build and run the application:**
   - Use an emulator or connect an Android device to run the app.

## Project Structure
- **`app/`**: Contains the main application source code, including activities, fragments, and resources.
- **`gradle/`**: Includes Gradle wrapper files for consistent build management.
- **Root files:**
  - **`.gitignore`**: Specifies files and directories to be ignored by Git.
  - **`build.gradle.kts`**: Kotlin-based Gradle build script for project configuration.
  - **`settings.gradle.kts`**: Kotlin-based Gradle settings script.

## Dependencies
The project uses common libraries for Android game development. Make sure to sync the project in Android Studio to download and configure all dependencies.

## Contributing
Contributions are welcome!

1. **Fork the repository:**
   - Click the 'Fork' button at the top right of the repository page.
2. **Clone your fork:**
   ```bash
   git clone https://github.com/your-username/ClickyHeroApp.git
   ```
3. **Create a new branch:**
   ```bash
   git checkout -b feature/your-feature-name
   ```
4. **Make your changes:** Implement your feature or fix.
5. **Commit your changes:**
   ```bash
   git commit -m "Add your commit message here"
   ```
6. **Push to your fork:**
   ```bash
   git push origin feature/your-feature-name
   ```
7. **Submit a pull request:** Navigate to the original repository and click 'New Pull Request'.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or feedback, please open an issue in this repository.
