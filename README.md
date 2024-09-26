# Donation Application

Welcome to the Donation Application! This application allows donors to register donations and recipients to view and claim available donations. It aims to facilitate the process of donating and receiving food donations in a user-friendly manner.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [How to Use](#how-to-use)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
- **User Authentication:** Donors and recipients can log in using their email and password.
- **Donation Registration:** Donors can register donations, including food type, quantity, and expiration date.
- **View Donations:** Donors can view their registered donations.
- **Available Donations:** Recipients can view available donations, including details about who claimed them.
- **Claim Donations:** Recipients can claim available donations.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Collections Framework

## Getting Started

To run this application locally, follow these steps:

1. **Clone the Repository:**
   ```bash
   https://github.com/Jeneliya12/Food_Donation_App.git
   
2. **Navigate to the Project Directory:**
    ```bash
   cd Food_Donation_App

3. **Compile the Application:**
    ```bash
   javac Data/Client/Client.java

4. **Run the Application**
    ```bash
   java Data.Client.Client
   
## How to Use
1. Login:
- **Choose whether you are a donor or a recipient and log in using your registered email and password.**

2. For Donors:
- **Register a new donation by providing the food type, quantity, unit, and expiration date.**
- **View your registered donations.**

3. For Recipients:
- **View available donations.**
- **Claim a donation by entering the food type.**

4. Claim Status:
- **After claiming, you can check the status of donations to see which ones you have claimed..**

## Project Structure
Food Donation App/
│
├── Data/
│   ├── Client/
│   │   └── Client.java            # Main application logic
│   ├── Impl/
│   │   ├── DonationImpl.java       # Handles donation operations
│   │   ├── DonorImpl.java          # Handles donor operations
│   │   └── RecipientImpl.java       # Handles recipient operations
│   ├── Interface/
│   │   ├── DonationInterface.java    # Donation interface definition
│   │   ├── DonorInterface.java       # Donor interface definition
│   │   ├── RecipientInterface.java    # Recipient interface definition
│   │   └── UserInterface.java        # User interface definition
│   └── models/
│       ├── Donation.java             # Donation model
│       ├── Donor.java                # Donor model
│       └── Recipient.java            # Recipient model
│
├── Main.java                        # Main application entry point
└── README.md                        # This README file

## Contributing
If you'd like to contribute to this project, feel free to submit a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contact
For any inquiries or feedback, feel free to reach out to me:

    Name: Jeneliya Gurung
    Email: gurungjeneliya@gmail.com

Thank you for checking out this project! Happy donating!

Feel free to make any additional modifications or let me know if you need further changes!



