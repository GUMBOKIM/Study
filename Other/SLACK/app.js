const Slack = require("slack-node");

const WebHookURL =
  "https://hooks.slack.com/services/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";
const userName = "강해찬";

const slack = new Slack();

slack.setWebhook(WebHookURL);

const send = async (message) => {
  slack.webhook(
    {
      channel: `@${userName}`,
      text: "짬뽕",
    },
    function (err, response) {
      console.log(response);
    }
  );
};

send();
