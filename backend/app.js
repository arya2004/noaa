const express=require('express')
const mongoose=require('mongoose')
const cors=require('cors')

const app=express();

app.use(cors());
app.use(express.json())

mongoose.connect('',{
    useNewUrlParser:true,
    useUnifiedTopology:true,
})

const db = mongoose.connection;
db.once('open', () => {
  console.log('Connected to MongoDB');
});


const problemSchema = new mongoose.Schema({
  problemName: String,
  problemCode: String,
  difficulty: String,
  tags: String,
  
});
const Problem = mongoose.model('Problem', problemSchema);


app.get('/api/problems', async (req, res) => {
  const { tag } = req.query;
  try {
    const problems = await Problem.find({ tags: tag });
    res.json(problems);
  } catch (error) {
    console.error('Error fetching data:', error);
    res.status(500).json({ error: 'Server error' });
  }
});

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
