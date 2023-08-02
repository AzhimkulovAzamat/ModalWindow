# ModalWindow
![Release](https://jitpack.io/v/AzhimkulovAzamat/ModalWindow.svg)

## Introduction
The **ModalWindow** library is designed to simplify and streamline the process of creating custom alert dialogs, bottom sheets, and snackbars within the internal projects of our company, Breez Pro. This library adheres to the standards and guidelines set by our company, making it easy for developers to create complex UI designs with minimal effort.

## Features
- Create custom alert dialogs, bottom sheets, and snackbars.
- Easy customization of complicated designs.
- Flexible and straightforward implementation.

## Requirements
- Minimum Android SDK version: 19 (Android 4.4 KitKat).

## Integration
To integrate the ModalWindow library into your project, follow these steps:

1. Add the following repository URL to your root **build.gradle** file:
   ```groovy
   allprojects {
     repositories {
        // Other repositories...
       maven { url 'https://jitpack.io' }
     }
   }
2. Add the following dependency to your application **build.gradle** file:
   ```groovy
   dependencies {
     implementation 'com.github.AzhimkulovAzamat:ModalWindow:LastVersion'
   }
   Replace **LastVersion** with the specific version or commit tag you want to use.

## Usage
### Custom Alert Dialog
To use the ModalWindow library, follow these steps:
1. In the application class, perform the initial settings using the ***AlertDialogBuilderConfig*** class:
   ```kotlin
   class YourApplicationClass {
   
     override fun onCreate() {
        super.onCreate()
        // Other settings
        setupModalWindow()
     }

     private fun setupModalWindow() {
       AlertDialogBuilderConfig.newConfig()
        .setNotificationLayoutId(R.layout.your_notification_dialog_layout)
        .setAlternativeLayoutId(R.layout.your_alternative_dialog_layout)
        .setRadioLayoutId(R.layout.your_radio_dialog_layout)
        .build()
     }
   }
2. Launch the desired modal window in your viewModel using the provided interfaces:
   #### NotificationDialogBuilder:
     ```kotlin
     val notificationBuilder = AlertDialogBuilderFactory.provideNotificationBuilder()

     notificationBuilder.setTitle(R.string.notification_title)
      .setMessage(R.string.notification_message)
      .setIcon(R.drawable.notification_icon)
      .setConfirmButtonTitle(R.string.confirm_button_title)
      .setConfirmButtonClickedListener {
          // Handle button click
      }
      .show()
     ```

   #### AlternativeDialogBuilder:
     ```kotlin
     val alternativeBuilder = AlertDialogBuilderFactory.provideAlternativeBuilder()

     alternativeBuilder.setTitle(R.string.alternative_title)
      .setMessage(R.string.alternative_message)
      .setIcon(R.drawable.alternative_icon)
      .setPositiveTitle(R.string.positive_button_title)
      .setPositiveClickedListener {
          // Handle positive button click
      }
      .setNegativeTitle(R.string.negative_button_title)
      .setNegativeClickedListener {
          // Handle negative button click
      }
      .show()
     ```

   #### RadioDialogBuilder:
     ```kotlin
     val radioBuilder = AlertDialogBuilderFactory.provideRadioBuilder()

     radioBuilder.setTitle(R.string.radio_title)
      .setMessage(R.string.radio_message)
      .setIcon(R.drawable.radio_icon)
      .setSubmitTitle(R.string.submit_button_title)
      .setSubmitClickedListener {
          // Handle submit button click
      }
      .setCancelTitle(R.string.cancel_button_title)
      .setCancelClickedListener {
          // Handle cancel button click
      }
      .setInteraction(interactionObject)
      .show()
     ```
   