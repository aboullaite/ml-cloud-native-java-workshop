# Using Gemini

This last step is a brief introduction to adding another endpoint powered by Google latest LLM model, Gemini.

### Switch to a new code branch
In your termed session, switch to the `gemini` branch
```shell
git checkout gemini
```
We added a new `chat-gemini` in `ModelResource` class that uses Gemini. The important additional pieces are below

```java
 ChatLanguageModel model = VertexAiGeminiChatModel.builder()
    .project("mohamed-playground")
    .project(System.getenv("PROJECT_ID"))
    .location(System.getenv("LOCATION"))
    .build();

    String aiMessage = model.generate(userMessage);

    return List.of(
    "Me:     " + userMessage,
    "Agent:  " + aiMessage.trim());
```
In this  example, we used the `VertexAiGeminiChatModel` class, which implements the ChatModel interface. This class is a wrapper around the Vertex AI API, which allows you to interact with the Gemini model.
Next, we're going to configure the chat language model, by using the builder for the `VertexAiGeminiChatModel`.
Now that the language model is ready, we can call the generate() method and pass your "prompt" (ie. your question or instructions to send to the LLM).

Before running the examples, you'll need to set up two environment variables:

```shell
export PROJECT_ID=YOUR_PROJECT_ID
export LOCATION=us-central1
````
### Deploy the app locally

Use the Maven wrapper to start the application by using the [Liberty dev mode](https://openliberty.io/docs/latest/development-mode.html):

```
./mvnw liberty:dev
```

### Test the application
Navigate to the [OpenAPI UI](http://localhost:9080/openapi/ui), and you can see that we have an additional endpoint now, `/api/model/chat-gemini`.

- expand the GET `/api/model/chat-gemini` API
    1. Click the **Try it out** button.
    2. Type `Which are the most used Large Language Models?`, or any question, in the question field.
    3. Click the **Execute** button.
- Alternatively, open a new Terminal Tab in Cloud Shell and run the following `curl` command from a command-line session:
    - ```
      curl -s 'http://localhost:9080/api/model/chat?userMessage=Which%20are%20the%20most%20used%20Large%20Language%20models%3F' | jq
      ```
