// Require the Node Slack SDK package (github.com/slackapi/node-slack-sdk)
import { WebClient, LogLevel } from '@slack/web-api';

// WebClient insantiates a client that can call API methods
// When using Bolt, you can use either `app.client` or the `client` passed to listeners.
const client = new WebClient(
  'xoxb-2432907671639-2452854131587-VrZM2rGLPXbH8JnKchWMs8NR',
  {
    // LogLevel can be imported and used to make debugging simpler
    logLevel: LogLevel.DEBUG,
  }
);

// Find conversation ID using the conversations.list method
async function findConversation(name) {
  try {
    // Call the conversations.list method using the built-in WebClient
    const result = await client.conversations.list({
      // The token you used to initialize your app
      token: 'xoxb-2432907671639-2452854131587-VrZM2rGLPXbH8JnKchWMs8NR',
    });

    for (const channel of result.channels) {
      console.log(channel.name);
      if (channel.name === name) {
        conversationId = channel.id;

        // Print result
        console.log('Found conversation ID: ' + conversationId);
        // Break from for loop
        break;
      }
    }
  } catch (error) {
    console.log('실패했다');
    console.error(error);
  }
}

// 채널 이름으로 찾음
async function publishMessage(id, text) {
  try {
    // Call the chat.postMessage method using the built-in WebClient
    const result = await client.chat.postMessage({
      // The token you used to initialize your app
      token: 'xoxb-2432907671639-2452854131587-VrZM2rGLPXbH8JnKchWMs8NR',
      channel: id,
      text: text,
      // You could also use a blocks[] array to send richer content
    });

    // Print result, which includes information about the message (like TS)
    console.log(result);
  } catch (error) {
    console.error(error);
  }
}

async function publishDirectMessage(id, text) {
  try {
    // Call the chat.postMessage method using the built-in WebClient
    const result = await client.im.write({
      // The token you used to initialize your app
      token: 'xoxb-2432907671639-2452854131587-VrZM2rGLPXbH8JnKchWMs8NR',
      channel: id,
      text: text,
      // You could also use a blocks[] array to send richer content
    });

    // Print result, which includes information about the message (like TS)
    console.log(result);
  } catch (error) {
    console.error(error);
  }
}

async function getUserIDlist() {
  try {
    // Call the chat.postMessage method using the built-in WebClient
    const result = await client.users.identity({
      // The token you used to initialize your app
      token: 'xoxb-2432907671639-2452854131587-VrZM2rGLPXbH8JnKchWMs8NR',
      // You could also use a blocks[] array to send richer content
    });

    // Print result, which includes information about the message (like TS)
    console.log(result);
  } catch (error) {
    console.error(error);
  }
}

getUserIDlist();