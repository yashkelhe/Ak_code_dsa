import gTTS
import pygame
import os

def text_to_speech(text, character_name, save_path="output.mp3"):
    # Generate speech using gTTS
    tts = gTTS(text=text, lang='en', slow=False)
    
    # Save the generated speech to a file
    tts.save(save_path)
    
    # Play the speech using pygame
    pygame.mixer.init()
    pygame.mixer.music.load(save_path)
    pygame.mixer.music.play()
    
    # Wait for the speech to finish playing
    while pygame.mixer.music.get_busy():
        pygame.time.Clock().tick(10)
    
    # Print the character name and text
    print(f"{character_name}: {text}")
    
    # Clean up: Remove the temporary audio file
    os.remove(save_path)

# Example usage
text_to_speech("Hello, how are you?", "John")

# You can also specify a custom file path to save the speech
# text_to_speech("I'm doing well, thank you!", "Alice", save_path="alice_speech.mp3")
