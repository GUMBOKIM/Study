import axios from 'axios';

const sendSlackMessage = (meta, fileName, email) => {

  const text = `123456789`

  let data = {
    username: 'EGG SCHOOL MSG',
    text
  };

  if (email) {
    const channel = '@' + email.split('@')[0];
    data = {
      ...data,
      channel
    };

  }

  data.channel = 'asdasd'

  return axios.post(`https://hooks.slack.com/services/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`, data);
};

console.log(new Date())