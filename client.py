import concurrent.futures
import requests

x = "0"
def send_request(url):
    try:
        global x
        # Define the payload (e.g., JSON) for the request
        x = x + "0" # Replace with your payload
        url = url + "?email=" + x + "@gmail.com"
        # Send an HTTP POST request to the specified URL
        response = requests.get(url)

        # Print the response status code and body
        print("Response code:", response.status_code)
        print("Response body:", response.text)
    except Exception as e:
        print("Error:", e)

if __name__ == "__main__":
    # Define the target URL of your REST controller
    url = "http://localhost:8080/otp/generate"  # Replace with your actual URL

    # Create a thread pool executor with a maximum of 10 threads
    with concurrent.futures.ThreadPoolExecutor(max_workers=100) as executor:
        # Submit tasks to the executor to send requests concurrently
        futures = [executor.submit(send_request, url) for _ in range(15000)]
        
        # Wait for all tasks to complete
        concurrent.futures.wait(futures)

