using Microsoft.AspNetCore.Identity;

namespace Xphyrus.SubmissionAPI.Models
{
    public class UserSubmissionandSulition
    {   
        public int UserSubmissionandSulitionId { get; set; }
        public string? source_code { get; set; }
        public int? language_id { get; set; }

        public DateTime CreatedON { get; set; } = DateTime.UtcNow;
     
        public int StudentId  { get; set; }
        public int AssignmentId { get; set; }
        public int AssesmentId { get; set; }

    }
}
